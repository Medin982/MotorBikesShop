const discussionId = document.getElementById('discussionId').value
const commentForm = document.getElementById('commentForm')
commentForm.addEventListener('submit', handlerFormSubmission)

const csrfHeaderName = document.head.querySelector('[name=_csrf_header]').content
const csrfHeaderValue = document.head.querySelector('[name=_csrf]').content
const commentContainer = document.getElementById("commentCtr")

async function handlerFormSubmission(event) {
    event.preventDefault()

    const message = document.getElementById('message').value

    fetch(`http://localhost:8080/api/discussion/details/${discussionId}`, {
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
            commentContainer.innerHTML += commentAsHtml(date)
        })
}

function commentAsHtml(comment) {
    let commentHtml = `<div class="d-flex flex-start align-items-center">\n`
    commentHtml += `<div>\n`
    commentHtml += `<h6 class="fw-bold text-primary mb-1">${comment.author}</h6>\n`
    commentHtml += `<p className="text-muted small mb-0">${comment.created}</p>\n`
    commentHtml += `</div>\n`
    commentHtml += `</div>\n`
    commentHtml += `<p class="mt-3 mb-4 pb-2 font-weight-bold">${comment.message}</p>\n`

    return commentHtml
}

fetch(`http://localhost:8080/api/discussion/details/${discussionId}`, {
    headers: {
        "Accepts": "application/json"
    }
}).then(res => res.json())
    .then(data => {
        for (let comment of data) {
            commentContainer.innerHTML += commentAsHtml(comment)
        }
    })