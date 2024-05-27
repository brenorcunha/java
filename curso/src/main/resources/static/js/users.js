// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#users').DataTable();
});
// CONT. DE 
// Function for sending all the data manually o the tabled of 'users.html'.
async function chargeUser() {
  const request = await fetch('users', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
    //body: JSON.stringify({a:1, b:'Textual content'})
  });
  const users = await request.json();
  console.log(users)
  let usersList = ' ';
  for (let user of users) {
    let userHtml = '<tr><td>'+user.id+'</td><td>'+ 
    user.firstName+'</td><td>' +
    user.lastName+'</td><td>' +
    user.email +'</td><td>'+ 
    user.phone+'</td><td><a href="s" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';
    usersList+=userHtml
  }
  document.querySelector('#users tbody').outerHTML = usersList
}
chargeUser()