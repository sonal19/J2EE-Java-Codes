function abc() {
	$("#tableEdit").tableEdit({
		columnsTr : "2,3,4", // null = all columns editable
		enableDblClick : true, // enable edit td with dblclick
		callback : function(e) {
			alert(e.empNo + ' ' + e.name + ' ' + e.loc + ' ' + e.dob);
			// console.log(e.age);
			/*
			 * code for ajax
			 */
			$.ajax({
				type : "post",
				url : "editEmployee", // this is my servlet
				data : {
					empNumber : e.empNo,
					empName : e.name,
					empLocation : e.loc,
					empEmail : e.email,
					empDOB : e.dob
				},
				success : function(msg) {
					console.log("File updated In Database");
				}
			});

		},
		activeMasks : function() {
			console.log("function enable masks");
			/*
			 * function for active masks
			 */
		}
	});

	
	$(document).on('click', '[action=Delete]', DeleteUser);

}
function DeleteUser() {
	if (confirm("Sure are you want to delete the Item?")) {
		$(this).closest('tr').remove();
		//alert($(this).closest('tr').find('td:nth-child(1)').html());
		$.ajax({
			type : "post",
			url : "deleteEmployee", // this is my servlet
			data : {
				empNumber : $(this).closest('tr').find('td:nth-child(1)')
						.html()
			},
			success : function(msg) {
				console.log("deleted In db");
			}
		});

		 //location.reload();
	}
}