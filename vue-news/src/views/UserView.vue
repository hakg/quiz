<template>
  <div>
    <p>{{this.$store.state.user.id}}</p>
    <p>{{this.$store.state.user.karma}}</p>
    <p>{{this.$store.state.user.created}}</p>

  </div>
</template>

<script>
import axios from "axios";
export default {
  created() {
    const userName = this.$route.params.id;
    this.$store.dispatch('FETCH_USER', userName);
  }
}
</script>

<style>

</style>