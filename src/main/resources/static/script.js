const API_URL = "http://localhost:8080/api/students";

function saveStudent() {
    const student = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        course: document.getElementById("course").value
    };

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(student)
    })
    .then(response => response.json())
    .then(data => {
        alert("Student Saved Successfully!");
        loadStudents();
    });
}

function loadStudents() {
    fetch(API_URL)
    .then(response => response.json())
    .then(data => {
        let output = "<h3>Student List</h3>";
        data.forEach(student => {
            output += `
                <p>
                    <b>Name:</b> ${student.name} <br>
                    <b>Email:</b> ${student.email} <br>
                    <b>Course:</b> ${student.course}
                </p>
                <hr>
            `;
        });

        document.getElementById("studentList").innerHTML = output;
    });
}
