$(document).ready(function () {
  chargeUsers();
  $("#users").DataTable({});
});

async function chargeUsers() {
  try {
    const usersList = [];
    const response = await fetch(`/users`, {
      method: "GET",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    });
    const users = await response.json();
     if(!users || users.length ===0){
        document.querySelector("#users tbody").innerHTML = '<tr><td colspan="6">There are no users in this table (1).</td></tr>';
      } else{
        usersList = users.map(
          (user) => `
            <tr>
              <td>${user.id}</td>
              <td>${user.first_name}</td>
              <td>${user.last_name}</td>
              <td>${user.email}</td>
              <td>${user.phone}</td>
              <td>
                <button onclick="delUser(${user.id})" class="btn btn-danger btn-circle btn-sm">
                  <i class="fas fa-trash"></i>
                </button>
              </td>
            </tr>
            `
            )
            .join("");
            document.querySelector("#users tbody").innerHTML = usersList;
      }
  } catch (error) {
    document.querySelector("#users tbody").innerHTML = '<tr><td colspan="6">There are no users in this table.</td></tr>';
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
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    });

    // Update the table without reloading the page
    chargeUsers();
    alert(`DELETED id: ${id}`);
  } catch (error) {
    console.error("Error deleting user:", error);
  }
}
