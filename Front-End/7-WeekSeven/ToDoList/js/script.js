document.addEventListener('DOMContentLoaded', function() {

    // Elements
    const addButton = document.getElementById("liveToastBtn");
    const todoListContainer = document.getElementById("list");
    const todoListInput = document.getElementById("task");

    const hardcodedTodos = [
        { text: "3 Litre Su İç", completed: false },
        { text: "Ödevleri Yap", completed: false },
        { text: "En Az 3 Saat Kodlama Yap", completed: false },
        { text: "Yemek Yap", completed: false },
        { text: "50 Sayfa Kitap Oku", completed: false }
    ];
    
    
    // Functions
    function loadTodos() {
        const localTodos = JSON.parse(localStorage.getItem("todos"));

        if (localTodos && localTodos.length > 0) {
            console.log("Loaded todos from localStorage:", localTodos);
            localTodos.forEach(todo => addTodoToList(todo));
        } else {
            console.log("Loading hardcoded todos");
            hardcodedTodos.forEach(todo => addTodoToList(todo));
            saveTodos(); // Save hardcoded todos to localStorage
        }
    }
    
    // Save todos to localStorage
    function saveTodos() {
        const allTodos = todoListContainer.querySelectorAll("li");
        const todosArray = [];
        allTodos.forEach(todo => {
            todosArray.push({
                text: todo.querySelector('.todo-text').innerText,
                completed: todo.classList.contains("completed")
            });
        });
        localStorage.setItem("todos", JSON.stringify(todosArray));
    }

    function addTodoToList(todo) {
        const listItem = document.createElement('li');
        listItem.className = 'd-flex align-items-center';
        if (todo) {
            listItem.classList.toggle('completed', todo.completed);
            listItem.innerHTML = `
                <span class="todo-text">${todo.text}</span>
                <div class="d-flex ml-auto">
                    <button class="check border-0 btn-transition btn btn-outline-success mr-1">
                        <i class="fa fa-check"></i>
                    </button>
                    <button class="trash border-0 btn-transition btn btn-outline-danger mr-1">
                        <i class="fa fa-trash-can"></i>
                    </button>
                </div>
            `;
        } else {
            const todoText = todoListInput.value.trim();
            if (todoText) {
                listItem.innerHTML = `
                    <span class="todo-text">${todoText}</span>
                    <div class="d-flex ml-auto">
                        <button class="check border-0 btn-transition btn btn-outline-success mr-1">
                            <i class="fa fa-check"></i>
                        </button>
                        <button class="trash border-0 btn-transition btn btn-outline-danger mr-1">
                            <i class="fa fa-trash-can"></i>
                        </button>
                    </div>
                `;
                todoListInput.value = "";
            } else {
                return;
            }
        }
        todoListContainer.appendChild(listItem);
    }


    // Event Listeners
    addButton.addEventListener("click", (event) => {
        event.preventDefault();
        const todoText = todoListInput.value.trim();
        if (todoText) {
            addTodoToList();
            saveTodos();
        } else {
            // Show error toast
            const errorToast = document.querySelector(".toast.error");
            const bootstrapToast = new bootstrap.Toast(errorToast);
            bootstrapToast.show();
            todoListInput.value = "";
        }
    })

    todoListContainer.addEventListener("click", function(event) {
        if (event.target.closest(".trash")) {
            const listItem = event.target.closest("li");
            listItem.remove();
            saveTodos();
        } else if (event.target.closest(".check")) {
            const listItem = event.target.closest("li");
            listItem.classList.toggle("completed");
            saveTodos();
        }
    });

    
    loadTodos();
})