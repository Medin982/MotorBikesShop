var indexPic=0;
$("#button-add-picture").click(function () {
    let html = '';
    html += '<div class="group-picture input-group row ">\n' +
        '                    <label for="name" class="form-label gold-text col-md-3">Picture title</label>\n' +
        '                    <input th:errorclass="is-invalid" required minlength="1" maxlength="20"\n' +
        '                           name="picturesBind['+ indexPic+'].namePicture" th:value="*{picturesBind['+ indexPic+'].namePicture}"\n' +
        '                           class="form-control input col-md-4 col-4" type="text" id="name-'+indexPic+'">\n' +
        '                    <input th:errorclass="is-invalid" required\n' +
        '                            name="picturesBind['+ indexPic+'].pictureFile" th:value="*{picturesBind['+ indexPic+'].pictureFile}"\n' +
        '                           class="form-control input col-md-5 col-5" type="file" id="picture-'+indexPic+'">\n' +
        '                </div>';

    indexPic++;
    $('#pictures').append(html);
});