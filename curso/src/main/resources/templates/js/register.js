// Call the dataTables jQuery plugin
$(document).ready(function () {});

// Function for sending all the data manually to the table in 'users.html'.
async function registerUser() {
  let rdata = {};
  rdata.email = document.getElementById("InputEmail").value;
  rdata.firstName = document.getElementById("InputFirstName").value;
  rdata.lastName = document.getElementById("InputLastName").value;
  rdata.phone = document.getElementById("InputPhone").value;
  rdata.password = document.getElementById("InputPassword").value;
  let repeatPwd = document.getElementById("RepeatPassword").value;

  if (repeatPwd != rdata.password) {
    alert("The passwords are not equal! Try again.");
    document.getElementById("InputPassword").value = "";
    document.getElementById("RepeatPassword").value = "";
    return;
  }
  try {
    const request = await fetch("http://localhost:8080/users", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify(rdata),
      // Takes the response and converts it to a JSON String.
    });
    alert("User successfully registered!");
    document.getElementById("InputEmail").value = "";
    document.getElementById("InputPhone").value = "";
    document.getElementById("InputFirstName").value = "";
    document.getElementById("InputLastName").value = "";
    document.getElementById("InputPassword").value = "";
    document.getElementById("RepeatPassword").value = "";

    await request.json();
  } catch (error) {
    console.error("Another error occured: ", error);
  }
}
