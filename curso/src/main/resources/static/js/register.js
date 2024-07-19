// Call the dataTables jQuery plugin
$(document).ready(function () {});

// Function for sending all the data manually to the table in 'users.html'.
async function registerUser() {
    const rdata = {};
    rdata.firstName = document.getElementById('FirstName').value
    rdata.lastName = document.getElementById('LastName').value
    rdata.email = document.getElementById('InputEmail').value
    rdata.phone = document.getElementById('InputPhone').value
    rdata.password = document.getElementById('InputPassword').value
    let repeatPwd = document.getElementById('RepeatPassword').value

    if (repeatPwd != rdata.password){
      alert(" The passwords are not equal! Try again.")
      document.getElementById('InputPassword').value = ''
      document.getElementById('RepeatPassword').value = ''
      return;
    }
    const request = await fetch("users", {
        method: "POST",
        headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
        },
        body: JSON.stringify(rdata)
        // Takes the response and converts it to a JSON String.
    });
  const usersr = await request.json();
}