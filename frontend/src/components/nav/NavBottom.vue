<template>
  <v-app-bar
    fixed
    color="#8BC34A"
    style="height: 56px;"
    class="mt-11"
  >
    <div class="text-center">
      <v-menu
        open-on-hover
        bottom
        offset-y
      >
        <template v-slot:activator="{ on, attrs }">
          <span
            v-bind="attrs"
            v-on="on"
            class="navlink"
          >
            그룹 테라피
          </span>
        </template>

        <v-list>
          <v-list-item
            v-for="(item, index) in items"
            :key="index"
            router :to="{ name: item.link }"
          >
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </div>
    <router-link :to="{ name: 'PostItems' }" class="navlink mx-3">커뮤니티</router-link>
  </v-app-bar>
</template>

<script>
export default {
  name: 'NavBottom',
  data: () => ({
      items: [
        { 
          title: '전문가모임',
          link: 'ProgramItems' 
        },
        { 
          title: '자조모임',
          link: 'PostItems' 
        },
      ],
    }),
}
</script>

<style>
.navlink {
  text-decoration: none;
  color: white !important; 
}
</style>