const discussionId = document.getElementById('discussionId').value
const commentForm = document.getElementById('commentForm')
commentForm.addEventListener('submit', handlerFormSubmission)

const csrfHeaderName = document.head.querySelector('[name=_csrf_header]').content
const csrfHeaderValue = document.head.querySelector('[name=_csrf]').content

async function handlerFormSubmission(event) {
    event.preventDefault()

    const message = document.getElementById('message').value

    fetch(`http://localhost:8080/forum/discussion/details/${discussionId}`, {
        method: 'post',
        headers: {
            'Content-Type': 'application/json',
            'Accepts': 'application/json',
            [csrfHeaderName]: csrfHeaderValue
        },
        body: JSON.stringify({
            message: message
        })
    }).then(res => res.json())
        .then(date => {
            document.getElementById('message').value = ""
        })
}