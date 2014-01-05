// JavaScript Document
var NavBar = {
	setActive:function( id ){
		$("ul.top-nav li").removeClass("active");
		var tmp = $("#" + id);
		if( !tmp ){
			return
		}
		tmp.addClass("active");
	}	
}