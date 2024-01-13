<script>
  export  default {
    created() {
      this.$store.dispatch('FETCH_ITEMS');
    }
  }
</script>

<template>
  <div class="fluid-container">

    <!-- widget grid -->
    <section id="widget-grid" class="">
      <!-- row-fluid -->

      <div class="row-fluid">
        <article class="span12">
          <!-- new widget -->
          <div class="jarviswidget"  id="widget-id-0" style="margin: 0 0 0 0">
            <header>
              <h2>대량메일 발송현황 리스트</h2>
            </header>
            <!-- wrap div start -->
            <div>
              <div class="inner-spacer">
                <!-- content goes here -->
                <!-- 본문 표시  -->

                <!-- -테이블 시작   -->
                <table	class="table" id="dataTable">
                  <thead>
                  <tr>
                    <th><input class="form-check-input" type="checkbox" value="" id="titleCheckbox"></th>
                    <!-- 대량메일ID -->
                    <th>대량메일ID</th>
                    <!-- 대량메일제목 -->
                    <th>대량메일제목</th>
                    <!-- 작성자명 -->
                    <th>작성자명</th>
                    <!-- 발송타입 -->
                    <th>발송타입</th>
                    <!-- 발송일-->
                    <th>발송일</th>

                  </tr>

                  </thead>
                  <tbody>
                  <tr v-for="(item, index) in this.$store.state.items" :key="index">
                    <td><input type="checkbox" v-model="selectedItems" :value="item" /></td> <!-- 체크박스 -->
                    <td>{{ item.massmailID }}</td>
                    <td>
                      <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                          {{ item.massmailTitle }}
                        </button>
                        <ul class="dropdown-menu">
                          <li><a class="dropdown-item" href="#">통계보기</a></li>
                          <li><a class="dropdown-item" href="#">대량메일 복사하기</a></li>
                        </ul>
                      </div>
                    </td>
                    <td>{{ item.senderName }}</td>
                    <td v-if="item.sendType === '1'">즉시발송</td>
                    <td v-else-if="item.sendType === '2'">에약발송</td>
                    <td>{{ item.registDate }}</td>
                    <!-- 나머지 속성들의 값 표시 -->
                  </tr>
                  </tbody>
                </table>
                <!-- -테이블 종료  -->
                <!-- 데이터 없을 경우  -->
                <table class="tms_nodata_table">

                </table>
              </div>

            </div>
            <!-- wrap div  end -->
          </div>
          <!-- 페이징 시작 -->
          <div style="margin-bottom:130px">
            <table class="tms_paging">
              <tr>
                <td style="width: 90%;">
                  <div id="Pagination" style="margin-top: 10px;"></div>
                </td>
                <td style="text-align: right; padding-top: 15px; padding-right: 20px; width: 100px;">
                  [&nbsp;<strong>Total:&nbsp;</strong><span id="totalCount"></span>&nbsp;]
                </td>
                <td style="text-align: right">
                  <select id="limit" name="limit" style="margin-top: 25px; width: 60px;">
                    <option value="10">10</option>
                    <option value="20">20</option>
                    <option value="30">30</option>
                  </select>
                </td>
              </tr>
            </table>
          </div>
          <!-- 페이징 종료 -->
        </article>
      </div>
    </section>
  </div>
</template>

<style scoped>

</style>