<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <script src="/resources/static/js/vue.js"></script>
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