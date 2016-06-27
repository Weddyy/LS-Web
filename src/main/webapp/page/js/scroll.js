window.onscroll = function()
{
    var html = document.documentElement, body = document.body;
    var BlkStyle = document.getElementById('top').style;
    if(html.scrollTop>5||body.scrollTop>5)
    {
        BlkStyle.backgroundColor="rgba(6, 6, 6, 1.0)";
    } else
    {
        BlkStyle.backgroundColor="rgba(6, 6, 6, 0.50)";
    }

}