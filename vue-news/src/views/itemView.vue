<template>
  <section>
    <div class="user-container">
      <div class="user-description">
        <i class="fas fa-user"></i>
      </div>
      <div>
        <div>
          <router-link :to="`/user/${fetchedItem.user}`">
            {{ fetchedItem.user}}
          </router-link>
        </div>
        <div class="time">
          {{fetchedItem.time_ago}}
        </div>
      </div>

    </div>
    <h2>
      {{ fetchedItem.title}}
    </h2>
  </section>
  <section>
    <div v-html="fetchedItem.content">

    </div>
  </section>
</template>

<script>
import {mapGetters} from 'vuex'
export default {
  computed : {
    ...mapGetters(['fetchedItem']),
  },
  created() {
    console.log(this.$route);
    const item = this.$route.params.id;
    this.$store.dispatch('FETCH_ITEM', item);
  }
}
</script>

<style scoped>
  .user-container {
    display: flex;
    align-items: center;
  }
  .fa-user {
    font-size: 2.5rem;
  }
  .user-description {
    padding-left: 8px;
  }
  .time {
    font-size: 0.7rem;
  }
</style>