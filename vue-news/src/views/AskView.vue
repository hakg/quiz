<template>
  <p v-for="item in fetchedAsk">
<!--    <a :href="item.url">{{ item.title }}</a>-->
    <router-link :to="`item/${item.id}`">
      {{item.title}}
    </router-link>
    <small>
      {{item.time_ago}} by {{item.user}}
    </small>
  </p>
</template>

<script>

import {mapState, mapGetters} from "vuex";

export default {
  computed: {
    ...mapGetters({
      fetchedAsk : 'fetchedAsk'
    })
    //#1
    // ...mapState({
    //   ask: state => state.ask
    // })
  },
  created() {
    console.log(this.$route);
    this.$store.dispatch('FETCH_ASK');
  }
}
</script>

<style>

</style>