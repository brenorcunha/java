// Call the dataTables jQuery plugin
$(document).ready(function () {});

// Function for sending all the data manually to the table in 'users.html'.
async function registerUser() {
  let rdata = {};
  rdata.FirstName = document.getElementById('InputFirstName').value
  rdata.LastName = document.getElementById('InputLastName').value
  rdata.Email = document.getElementById('InputEmail').value
  rdata.Phone = document.getElementById('InputPhone').value
  rdata.Password = document.getElementById('InputPassword').value
  let repeatPwd = document.getElementById('RepeatPassword').value

  if (repeatPwd != rdata.Password){
    alert('The passwords are not equal! Try again.')
    document.getElementById('InputPassword').value = ''
    document.getElementById('RepeatPassword').value = ''
    return;
  }
  try {
    const request = await fetch('http://localhost:8080/register', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(rdata),
      // Takes the response and converts it to a JSON String.
    });
    if(request.OK){
      let response = await request.json()
    } else{
      rdata.FirstName = ''
      rdata.LastName = ''
      rdata.Email = ''
      rdata.Phone = ''
      rdata.Password= ''
      console.log('[ALERT] Data went EMPTY!')
    }
  } catch (error) {
    console.error('Another error occured: ', error)
  }
}