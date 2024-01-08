function extractVideoId(youtubeUrl) {
    spl = youtubeUrl.split("v=")[1];
    console.log(spl)
    return spl
}

function generateThumbnailUrl(videoId) {
    src1 =`https://img.youtube.com/vi/${videoId}/mqdefault.jpg`;
    console.log(src1);
    return src1;

}