if( NavBar ){
	NavBar.setActive("navbar-message");
	
}

$('#left-menu a').click(function(e) {
	e.preventDefault();
	$(this).tab('show');
});

