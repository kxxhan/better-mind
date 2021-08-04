package com.ssafy.api.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.api.request.ProgramPostReq;
import com.ssafy.api.request.ReviewPostReq;
import com.ssafy.api.response.FileDto;
import com.ssafy.api.response.ProgramGetRes;
import com.ssafy.db.entity.CategoryEnum;
import com.ssafy.db.entity.Program;
import com.ssafy.db.entity.Program_File;
import com.ssafy.db.entity.Program_Review;
import com.ssafy.db.repository.ProgramRepository;
import com.ssafy.db.repository.Program_FileRepository;
import com.ssafy.db.repository.Program_ReviewRepository;
import com.ssafy.db.repository.UserRepository;

@Service("ProgramService")
public class ProgramServiceImpl implements ProgramService {

	@Autowired
	ProgramRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Program_ReviewRepository reviewRepository;
	
	@Autowired
	Program_FileRepository fileRepository;
	
	@Value("${server.tomcat.basedir}")
	private String basedir;
	
	@Override
	@Transactional
	public Program createProgram(ProgramPostReq programPostReq, MultipartFile[] files) 
			throws IllegalStateException, IOException {
		Program program = new Program();
		program.setUser(userRepository.findByUserid(programPostReq.getUserId()).get());
		program.setName(programPostReq.getName());
		program.setDescription(programPostReq.getDescription());
		program.setReport(programPostReq.getReport());
		program.setPrice(programPostReq.getPrice());
		program.setCount(programPostReq.getCount());
		program.setDate(programPostReq.getDate());
		program.setTime(programPostReq.getTime());
		program.setCategory(CategoryEnum.valueOf(programPostReq.getCategory()));
		program = repository.save(program);
		// 성무님 코드 참고...
		if(files != null) {
			String realPath = basedir;
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			String saveFolder = realPath+File.separator+today;
			File folder = new File(saveFolder);
			
			if(!folder.exists())
				folder.mkdirs();
			for(MultipartFile f : files) {
				String originalFileName = f.getOriginalFilename();
				if(!originalFileName.isEmpty()) {
					String saveFileName = UUID.randomUUID().toString()+originalFileName.substring(originalFileName.lastIndexOf('.'));
					f.transferTo(new File(folder, saveFileName));
					Program_File pfile = new Program_File();
					pfile.setSavefolder(saveFolder);
					pfile.setProgram(program);
					pfile.setOriginfile(originalFileName);
					pfile.setSavefile(saveFileName);
					fileRepository.save(pfile);
				}
			}
		}
		return program;
	}
	
	@Override
	public List<ProgramPostReq> getAllProgram(Pageable pageable) {
		List<Program> list = repository.findAll(pageable).getContent();
		List<ProgramPostReq> copy = new ArrayList<>();
		ProgramPostReq resp;
		for(Program p : list) {
			resp = new ProgramPostReq();
			resp.setId(p.getId());
			resp.setName(p.getName());
			resp.setUserId(p.getUser().getUserid());
			resp.setDescription(p.getDescription());
			resp.setReport(p.getReport());
			resp.setPrice(p.getPrice());
			resp.setCount(p.getCount());
			resp.setDate(p.getDate());
			resp.setTime(p.getTime());
			resp.setCategory(p.getCategory().name());
			copy.add(resp);
		}
		return copy;
	}
	
	@Override
	public long getAllProgramCount() {
		return repository.count();
	}
	
	@Override
	public ProgramGetRes getOneProgram(Long id){
		Program program = repository.findById(id).get();
//		Long uid = userRepository.findByUserid(userid).get().getId();
		ProgramGetRes p = new ProgramGetRes();
		p.setId(program.getId());
		p.setUserId(program.getUser().getUserid());
		p.setName(program.getName());
		p.setDescription(program.getDescription());
		p.setReport(program.getReport());
		p.setPrice(program.getPrice());
		p.setCount(program.getCount());
		p.setDate(program.getDate());
		p.setTime(program.getTime());
		List<Program_Review> plist = reviewRepository.findByProgram_id(program.getId()).get();
		if(plist != null) {
			List<ReviewPostReq> reviews = new ArrayList<>();
			for(Program_Review k: plist) {
				ReviewPostReq r = new ReviewPostReq();
				r.setContent(k.getContent());
				r.setUserId(k.getUser().getUserid());
				reviews.add(r);
			}
			p.setReviews(reviews);
		}
		List<Program_File> list = fileRepository.findByProgram(id).get();
		if(list != null) {
			List<FileDto> copy = new ArrayList<>();
			for(Program_File fi : list) {
				FileDto dto = new FileDto();
				dto.setOriginfile(fi.getOriginfile());
				dto.setSavefile(fi.getSavefile());
				dto.setSavefolder(fi.getSavefolder());
				copy.add(dto);
			}
			p.setFiles(copy);
		}
		return p;
	}
	
	@Override
	public Program updateProgram(Long id, ProgramPostReq programPostReq) {
		Program program = repository.getOne(id);
		program.setName(programPostReq.getName());
		program.setDescription(programPostReq.getDescription());
		program.setReport(programPostReq.getReport());
		program.setPrice(programPostReq.getPrice());
		program.setCount(programPostReq.getCount());
		program.setDate(programPostReq.getDate());
		program.setTime(programPostReq.getTime());
		return repository.save(program);
	}
	
	@Override
	public void deleteProgram(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Program_Review createReview(Long id, ReviewPostReq review) {
		Program_Review rev = new Program_Review();
		rev.setContent(review.getContent());
		rev.setUser(userRepository.findByUserid(review.getUserId()).get());
		Program pro = repository.getOne(id);
		rev.setProgram(pro);
		return reviewRepository.save(rev);
	}

	@Override
	public Program_Review updateReview(Long id, Long rId, ReviewPostReq review) {
		Program_Review rev = reviewRepository.getOne(rId);
		rev.setContent(review.getContent());
		rev.setUpdated_at(new Date());
		return reviewRepository.save(rev);
	}

	@Override
	public void deleteReview(Long pId, Long rId) {
		reviewRepository.deleteById(rId);
		
	}
	
}
