
function showMenu() {
    $.ajax({
    		type: 'POST',
    		dataType: 'JSON',
    		url:  '/menuList',
    		error:function() {
    			console.log("error");
    		},
    		success: function(returnJSON) {
    		/*
    		    <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                        aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>Components</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Custom Components:</h6>
                            <a class="collapse-item" href="buttons.html">Buttons</a>
                            <a class="collapse-item" href="cards.html">Cards</a>
                        </div>
                    </div>
                </li>
             */
//<a id="mainmenu" class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"'
                var records = '';
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

                            if (previousValue === menu.parentMenuID) {
                                records += '<h6 class="collapse-header">' + menu.menuName + '</h6>'
                                        +'<a class="collapse-item" href="buttons.html">'+ 'Problem Solving' +'</a>'
                            }

                            + '</div>'
                            + '</div>';

                    }

                    previousValue = menu.parentMenuID;

                });

                $('#menu').html(records);

                //클릭한 대메뉴의 서브 메뉴 보이게 하기
                $('a[name="mainmenu"]').bind('click', function() {

                    if($(this).attr('aria-expanded')=== 'true') {
                        $(this).attr('aria-expanded', 'false');
                        var divElement = $(this).next('div');
                        divElement.removeClass('collspace show').addClass('collspace');

                    } else {
                        var divElement = $(this).next('div');
                        $(this).attr('aria-expanded', 'true');
                        divElement.removeClass('collspace').addClass('collspace show');
                    }
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