<template>
  <div id="app">
    <Header></Header>
    <router-view></router-view>
  </div>
</template>

<script>
import Header from './components/Header.vue';

export default {
  components: { Header },
};
</script>

<style>
body {
  padding: 0;
  margin: 0;
}

</style>
