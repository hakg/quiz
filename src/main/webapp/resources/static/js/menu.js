
function showMenu() {
    $.ajax({
    		type: 'POST',
    		dataType: 'JSON',
    		url:  '/menuList',
    		error:function() {
    			console.log("error");
    		},
    		success: function(returnJSON) {
                var records = '';
                var previousParentValue = '';
                var splitArr;


                $.each(returnJSON.items, function(i, menu) {

                    if(menu.menuCode == menu.parentMenuID) {
                        records += '<li class="nav-item">'
                                + ' <a name="mainmenu" class="nav-link collapsed" href="#" data-toggle="collapse"'
                                + 'aria-expanded="false" aria-controls="collapseTwo">'
                                + '<i class="fas fa-fw fa-cog"></i>'
                                + '<span>' + menu.menuName +'</span>'
                                +'</a>'
                                +'<div id="collapse" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">'
                                +  '<div class="bg-white py-2 collapse-inner rounded">';

                    } else {

                            if (previousParentValue === menu.parentMenuID) {
                                var text = "회원정보;바보";
                                if(text.indexOf(";") > -1) {
                                    splitArr = text.split(";");

                                    for(var i =0; i < splitArr.length; i++) {
                                        var test = splitArr[i];
                                        console.log(test);
                                    }
                                        console.log(test);

                                }

                                records += '<h6 class="collapse-header">' + menu.menuName + '</h6>'
                                        +'<a name="submenu" class="collapse-item" href="#" url=' + menu.menuUrl + ' data-name=' + menu.menuName + '>'+ menu.submenuName +'</a>';
                            }

                            + '</div>'
                            + '</div>';

                    }

                    previousParentValue = menu.parentMenuID;

                });

                $('#menu').html(records);

                //클릭한 대메뉴의 서브 메뉴 보이게 하기
                $('a[name="mainmenu"]').bind('click', function() {

                    if($(this).attr('aria-expanded')=== 'true') {
                        $(this).attr('aria-expanded', 'false');
                        var divElement = $(this).next('div');

                        divElement.removeClass('collspace show').addClass('collspace');
                        $(this).removeClass('nav-link').addClass('nav-link collapsed');

                    } else {
                        var divElement = $(this).next('div');
                        $(this).attr('aria-expanded', 'true');
                        divElement.removeClass('collspace').addClass('collspace show');
                        $(this).removeClass('nav-link collapsed').addClass('nav-link');
                    }
                });

                $('a[name="submenu"]').bind('click', function() {
                    var url = $(this).attr('url');
                    var name = $(this).attr('data-name');


                    goSubMenu(url);
                    showQuestion(name,1);

                });
    		}

    });
}





/* ======================================================================================
 *  공통부분
 * ======================================================================================
 */
//초기 실행시 제일 먼저 실행하도록 하는 자바스크립트 실행문
//즉시 실행함수라고 보면 된다.
(function(){
    showMenu();
})();