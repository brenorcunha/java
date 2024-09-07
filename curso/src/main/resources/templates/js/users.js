$(document).ready(function () {
  chargeUsers();
  $("#users").DataTable({});
  showEmail();
});

function showEmail() {
  var email = localStorage.getItem("email")
  if (email) {
    document.getElementById("txtEmail").innerHTML = email;
  }
}
async function chargeUsers() {
  try {
    let users = Array();
    const response = await fetch("http://localhost:8080/users", {
      method: "GET",
      headers: {
        "Accept": "application/json",
        "Content-Type": "application/json",
        "Authorization": localStorage.token
      },
    });
    users = await response.json();
    if (users.length == 0) {
      document.querySelector("#users tbody").innerHTML =
        '<tr><td colspan="6">There are no users in this table (1).</td></tr>';
    } else {
      let usersList = users
        .map(
          (user) => `
            <tr>
              <td>${user.id}</td>
              <td>${user.email}</td>
              <td>${user.firstName}</td>
              <td>${user.lastName}</td>
              <td>${user.phone}</td>
              <td>
                <button onclick='delUser(${user.id})' class='btn btn-danger btn-circle btn-sm'>
                  <i class='fas fa-trash'></i>
                </button>
              </td>
            </tr>
            `
        )
        .join("");
      document.querySelector("#users tbody").innerHTML = usersList;
    }
  } catch (error) {
    document.querySelector("#users tbody").innerHTML =
      '<tr><td colspan="6">[1] There are no users in this table.</td></tr>';
    console.error("Error fetching user data:", error);
  }
}

async function delUser(id) {
  if (!confirm("Do you want to DELETE this user?")) {
    return;
  }

  try {
    await fetch(`/user/${id}`, {
      method: "DELETE",
      headers: {
        "Accept": "application/json",
        "Content-Type": "application/json",
        "Authorization": localStorage.token
      },
    });

    // Update the table without reloading the page
    chargeUsers();
    alert(`DELETED id: ${id}`);
  } catch (error) {
    console.error("Error deleting user:", error);
  }
}
