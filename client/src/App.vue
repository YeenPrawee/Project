<template>
  <v-app dark>
    <v-app-bar app class="cyan darken-2 white--text">
      <v-toolbar-title class="headline text-uppercase">
        <span>DOCTOR</span>
        <span class="font-weight-light"> information system</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn
        text
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
      >
        
      </v-btn>
    </v-app-bar>

    <v-content>
      <!-- <doctor/> -->
      <router-view />
    </v-content>
  </v-app>
</template>

<script>

export default {
  name: 'App',
  data: () => ({
    
  }),
};
</script>
