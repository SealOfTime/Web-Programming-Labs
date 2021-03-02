    setInterval(()=>{
    let d = new Date(),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear(),
        hour = d.getHours(),
        minute = d.getMinutes(),
        seconds = d.getSeconds();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;
    if(hour.length < 2)
        hour = '0' + hour;
    if(minute.length < 2)
        minute = '0' + minute;
    if(seconds.length < 2)
        seconds = '0' + seconds;
    console.log(clock);
    clock.innerHTML = `${hour}:${minute}:${seconds} ${day}-${month}-${year}`;
}, 7);