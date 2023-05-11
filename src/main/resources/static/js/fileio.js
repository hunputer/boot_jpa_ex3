const dropbox = document.querySelector('.file_box');
const input_filename = document.querySelector('.file_name');

//박스 안에 drag 하고 있을 때
dropbox.addEventListener('dragover', function (e) {
    e.preventDefault();

    let valid = e.dataTransfer.types.indexOf('Files') >= 0;

    if(valid){
        this.style.backgroundColor = 'rgb(13 110 253 / 25%)';
    }
});

//박스 밖으로 drag가 나갈 때
dropbox.addEventListener('dragleave', function (e) {
    this.style.backgroundColor = 'white';
});

//박스 안에 drop 했을 때
dropbox.addEventListener('drop', function (e) {
    e.preventDefault();
    this.style.backgroundColor = 'white';

    //파일 이름을 text로 표시
    let filename = e.dataTransfer.files[0].name;
    let file = e.dataTransfer.files[0];
    console.log(file);
    input_filename.innerHTML = filename;

    const formData = new FormData();
    formData.append('uploadFile', file);

    $.ajax({
        type: "POST",
        url: "/fileio/upload",
        data: formData,
        contentType : false,
        processData : false,
        enctype : "multipart/form-data",
        success: () => {
            alert("파일 저장이 완료되었습니다");
        }
    });
});