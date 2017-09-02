(function() {
	$(document).ready(function() {

		// Add Events
		$(document).on('click', '[action=Edit]', EditUser);
		$(document).on('click', '[action=Delete]', DeleteUser);

		$('#btnCancel').bind('click', CancelUser);
		$('form').on('click', '#btnSave', SaveUser);

	});

	function EditUser() {

		var image = {}, $selectedRow;
		$selectedRow = $(this).closest('tr');
		image.uid = parseInt($selectedRow.attr('ImageId'), 10);
		image.id = $selectedRow.find('td:nth-child(1)').html();
		image.name = $selectedRow.find('td:nth-child(2)').html();
		image.size = $selectedRow.find('td:nth-child(3)').html();
		image.hiddenId = $selectedRow.find('td:nth-child(4)').html();
		PreparePopup(image);
		// $UserFT.html('Edit Image Form');
		TogglePopup();

	}
	function CancelUser() {
		TogglePopup();
	}
	function DeleteUser() {
		if (confirm("Sure are you want to delete the Item?")) {
			$(this).closest('tr').remove();

			$.ajax({
				type : "post",
				url : "../DeleteImageServlet", // this is my servlet
				data : {
					imageId : $(this).closest('tr').find('td:nth-child(4)')
							.html()
				},
				success : function(msg) {
					alert("deleted In db");
				}
			});

			location.reload();
		}
	}

	function TogglePopup() {
		$('#popup').toggle();
		$('#overlay').toggle();
	}

	function SaveUser() {
		var image = {}, $row;
		image.hiddenId = parseInt($('#hiddenUserId').val(), 10);
		image.name = $('#txtName').val();

		if (image.name) {

			UpdateTr(image);

			TogglePopup();
		} else {
			alert("Name and Email can't be empty");
		}
	}
	function UpdateTr(image) {

		$.ajax({
			type : "post",
			url : "../EditImageServlet", // this is my servlet
			data : {
				imageId : image.hiddenId,
				editedName : image.name
			},
			success : function(msg) {
				alert("updated In db");
			}
		});

		location.reload();
		// $(this).closest('tr').find('td:nth-child(2)').html(image.name);

	}
	function PreparePopup(image) {
		$('#hiddenUserId').val(image.hiddenId);
		$('#txtName').val(image.name);

	}
});
