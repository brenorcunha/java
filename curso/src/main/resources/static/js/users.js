// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#users').DataTable();
});
// CONT. DE 2:41:10 Register users.
// Function for sending all the data manually to the tabled of 'users.html'.
async function chargeUser() {
  try {
    const request = await fetch('users', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
      //body: JSON.stringify({a:1, b:'Textual content'})
    });
    const users = await request.json();

    let usersList = '';
	
    if(isEmpty(usersList)){
      usersList = '<tr><td colspan="3"> There are no users in this table. </td></tr>';
      return usersList
    } else {
      for (let user of users) {
		  let delBtn = '<a href="s" onclick="delBtn('+ user.id +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
		  let userHtml = '<tr><td>'+user.id+'</td><td>'+ 
		  user.firstName+'</td><td>' +
		  user.lastName+'</td><td>' +
		  user.email +'</td><td>'+
		  user.phone+'</td><td>' + delBtn +'</td></tr>';
		  usersList+=userHtml
      }
    }
  } catch (error) {
    return console.error("[500 ERROR] Another error ocurred.");
  }
  document.querySelector('#users tbody').outerHTML = usersList
}
chargeUser()
async function delUser(id){
	if(!confirm('Do you want to DELETE this user?')){
		return;
	}
	const request = await fetch('users/' + {id}, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
	});
	location.reload();
	alert('id:', id)
}