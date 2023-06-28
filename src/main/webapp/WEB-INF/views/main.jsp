<html>
<head>
    <!-- Vue.js 파일 로드 -->
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
</head>
<body>
    <!-- Vue.js를 사용한 내용 작성 -->
    <div id="app">
        {{ message }}
    </div>

    <!-- Vue 인스턴스 생성 및 사용 -->
    <script>
        new Vue({
            el: '#app',
            data: {
                message: 'Hello, Vue!'
            }
        });
    </script>
</body>
</html>