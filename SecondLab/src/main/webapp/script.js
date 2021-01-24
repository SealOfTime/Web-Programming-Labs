const canvas = document.getElementById("plot-canvas");
const ctx = canvas.getContext('2d');
const rVal = document.getElementsByName("r");
const pointForm = document.getElementById("form-point");
const points = [];

canvas.addEventListener("click", (e)=>{
    const rect = canvas.getBoundingClientRect();
    const r = getRValue();
    const x = (e.clientX - rect.left-200)*r/150;
    const y = -(e.clientY - rect.top-200)*r/150;
    console.log("x: " + x + " y: " + y);
    let data = new FormData();
    data.append("x", x);
    data.append("y", y);
    data.append("r", r);
    checkPoint(data);
})

rVal.forEach(button=>button.addEventListener("change", ()=>{
    redrawCanvas(button.value);
}));
function getRValue(){
    let value;
    for(let radio of rVal)
        if(radio.checked)
            value=radio.value;
    return value;
}

pointForm.addEventListener("submit",  (e)=>{
    console.log(e);
    let data = new FormData(pointForm);
    checkPoint(data);
    e.preventDefault();
    return false;
});

async function checkPoint(data){
    let req = new XMLHttpRequest();
    let res = await fetch('./', {
        method: 'POST',
        body: data
    });
    addNewPoint(await res.json());
}

function addNewPoint(point){
    console.log(point);
    let newRow = document
        .getElementById("results-table")
        .insertRow(-1);
    point.color = "#" + Math.floor(Math.random()*16777215).toString(16);
    newRow.style.backgroundColor = point.color;
    newRow.insertCell(-1).textContent = point.x;
    newRow.insertCell(-1).textContent = point.y;
    newRow.insertCell(-1).textContent = point.r;
    newRow.insertCell(-1).textContent = point.isIn;
    drawPoint(point.x, point.y, point.r, point.color, point.isIn);
    points.push(point);
}

redrawCanvas();

function redrawCanvas(scale){
    ctx.fillStyle = "white";
    ctx.fillRect(0, 0, 400, 400);
    drawFigure(ctx);
    ctx.strokeStyle = "black";
    ctx.fillStyle = "black";
    drawAxis(ctx);
    drawText(ctx, scale);
    for(let point of points)
        drawPoint(point.x, point.y, scale, point.color);
}

function drawPoint(x, y, r, color, isIn){
    let scaleCoef = 150/r;
    const xOffset = 200;
    const yOffset = 200;
    let relX = scaleCoef * x + xOffset;
    let relY = -scaleCoef * y + yOffset;

    ctx.beginPath();
    ctx.fillStyle = color;
    ctx.strokeStyle = isIn ? "green" : "red";
    ctx.arc(relX, relY, 4, 0, 2*Math.PI);
    ctx.fill();
    ctx.stroke();
}

function drawAxis(ctx){
    ctx.moveTo(200, 0);
    ctx.lineTo(200, 400);
    ctx.moveTo(200, 0);
    ctx.lineTo(195, 20);
    ctx.moveTo(200, 0);
    ctx.lineTo(205, 20);
    ctx.moveTo(200, 0);

    ctx.moveTo(0, 200);
    ctx.lineTo(400, 200);
    ctx.lineTo(380,195);
    ctx.moveTo(400, 200);
    ctx.lineTo(380,205);
    ctx.stroke();
}

function drawText(ctx, scale){
    ctx.font = "18px Arial";
    let text = [];
    if(scale === undefined)
        text = ["-R", "-R/2", "R/2", "R"];
    else
        text = [-scale, -scale/2, scale/2, scale];
    ctx.fillText(text[3], 340, 195);
    ctx.fillText(text[2], 265, 195);
    ctx.fillText(text[1], 115, 195);
    ctx.fillText(text[0], 40, 195);

    ctx.fillText(text[0], 205, 350);
    ctx.fillText(text[1], 205, 290);
    ctx.fillText(text[2], 205, 110);
    ctx.fillText(text[3], 205, 40);
    ctx.fillText("y", 208, 15);
    ctx.fillText("x", 380, 220);
}

function drawFigure(ctx){
    ctx.strokeStyle = "#3399FF";
    ctx.fillStyle = "#3399FF";
    ctx.moveTo(200,  200);
    ctx.beginPath();
    ctx.lineTo(200, 100);
    ctx.lineTo(50, 200);

    ctx.lineTo(50, 350);
    ctx.lineTo(200, 350);
    ctx.lineTo(200, 275);

    ctx.arc(200, 200, 75, -3*Math.PI/2, 0, true);

    ctx.lineTo(200, 200);
    ctx.closePath();
    ctx.fill();
    ctx.stroke();
}