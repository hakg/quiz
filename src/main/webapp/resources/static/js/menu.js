
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

                var records = '';
                $.each(returnJSON.items, function(i, menu) {

                    if(menu.menuCode == menu.parentMenuID) {
                        records += '<li class="nav-item">'
                                + ' <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"'
                                + 'aria-expanded="true" aria-controls="collapseTwo">'
                                + '<i class="fas fa-fw fa-cog"></i>'
                                + '<span>' + menu.menuName +'</span>'
                                +'</a>';

                    } else {
                        records += '<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">'
                                +  '<div class="bg-white py-2 collapse-inner rounded">'
                                +  '<h6 class="collapse-header">' + menu.menuName + '</h6>'
                                + '<a class="collapse-item" href="buttons.html">'+ 'Problem Solving' +'</a>'

                                + '</div>'
                                + '</div>';
                    }



                });

                $('#menu').html(records);
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