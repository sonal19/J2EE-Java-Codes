window.onload=function(){

$('.form').find('input, textarea').on('keyup blur focus', function(e) {

	var $this = $(this), label = $this.prev('label');

	if (e.type === 'keyup') {
		if ($this.val() === '') {
			label.removeClass('active highlight');
		} else {
			label.addClass('active highlight');
		}
	} else if (e.type === 'blur') {
		if ($this.val() === '') {
			label.removeClass('active highlight');
		} else {
			label.removeClass('highlight');
		}
	} else if (e.type === 'focus') {

		if ($this.val() === '') {
			label.removeClass('highlight');
		} else if ($this.val() !== '') {
			label.addClass('highlight');
		}
	}

});

$('.tab a').on('click', function(e) {

	e.preventDefault();
	$("#forget").hide();

	$(this).parent().addClass('active');
	$(this).parent().siblings().removeClass('active');

	target = $(this).attr('href');

	$('.tab-content > div').not(target).hide();

	$(target).fadeIn(600);

});

$('.forgot a').on('click', function(e) {

	$("#forget").show();
});

$('#regBtn').click(function() {
	if ($('#fname').val() == "") {
		alert("Full Name can't be empty")
	}
	if ($('#email').val() == "") {
		alert("Email can't be empty")
	}
	if ($('#username').val() == "") {
		alert("Username can't be empty")
	}
	if ($('#password').val() == "") {
		alert("Password can't be empty")
	}
});
}