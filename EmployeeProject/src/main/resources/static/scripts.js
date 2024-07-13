const apiUrl = 'http://localhost:8080/employee';

// Fetch all employees
const fetchEmployees = async () => {
    const response = await fetch(`${apiUrl}/getemployee`);
    const employees = await response.json();
    const tbody = document.querySelector('#employee-table tbody');
    tbody.innerHTML = '';

    employees.forEach(employee => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>
                <button class="delete" onclick="deleteEmployee(${employee.id})">Delete</button>
                <button class="update" onclick="updateEmployee(${employee.id})">Update</button>
            </td>
        `;
        tbody.appendChild(tr);
    });
};

// Fetch employee by ID
const fetchEmployeeById = async () => {
    const id = document.getElementById('employee-id').value;
    const response = await fetch(`${apiUrl}/getbyid/${id}`);
    const employee = await response.json();

    const employeeDetailsDiv = document.getElementById('employee-details');
    employeeDetailsDiv.innerHTML = '';

    if (employee) {
        employeeDetailsDiv.innerHTML = `
            <p><strong>ID:</strong> ${employee.id}</p>
            <p><strong>Name:</strong> ${employee.name}</p>
            <p><strong>Email:</strong> ${employee.email}</p>
        `;
    } else {
        employeeDetailsDiv.innerHTML = `<p>Employee not found</p>`;
    }
};

// Create employee
document.getElementById('create-employee-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;

    const response = await fetch(`${apiUrl}/createemp`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ name, email })
    });

    if (response.ok) {
        fetchEmployees();
    }
});

// Delete employee
const deleteEmployee = async (id) => {
    await fetch(`${apiUrl}/deleteuser/${id}`, {
        method: 'DELETE'
    });

    fetchEmployees();
};

// Update employee
const updateEmployee = async (id) => {
    const name = prompt("Enter new name:");
    const email = prompt("Enter new email:");

    if (name && email) {
        await fetch(`${apiUrl}/updateuser/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ name, email })
        });

        fetchEmployees();
    }
};

// Initialize the page by fetching employees
fetchEmployees();
