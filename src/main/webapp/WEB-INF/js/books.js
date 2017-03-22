/**
 * Created by hou on 1/15/17.
 */
crawelBook=function () {
    this.load();
}
crawelBook.prototype.load=function () {
    $.ajax({
        url:'/crawel/crawelBooks',
        type:'get',
        succuess:function (data) {
            if(data){
                var str='';
                for(var i=0;i<data.list.length;i++){
                    str+='<td>'+data.list[i]+'</td>';
                }
                $('#tbody').html(str);
            }

        }
    })
}
