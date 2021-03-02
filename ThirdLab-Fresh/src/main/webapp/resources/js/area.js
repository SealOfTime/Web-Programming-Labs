let circlePoints;
circlePoints = document.getElementsByTagName("circle");
let svgLabels;
svgLabels =document.getElementsByTagName("text");

function sendData(e, plotCanvas){
    const rect = plotCanvas.getBoundingClientRect();
    const r = parseInt(getRValue());
    if(r && r !== 0) {
        const x = (e.clientX - rect.left - 200) * r / 160;
        if(x > 2 || x < -2){
            showModal("X should be between -2 and 2");
            return false;
        }
        const y = -(e.clientY - rect.top - 200) * r / 160;
        if(y < -5 || y > 3){
            showModal("Y should be between -5 and 3");
            return false;
        }
        console.log("x: " + x + " y: " + y + "r: " + r);
        setXValue(x);
        setYValue(y)
        document.getElementById("hidden:hiddenSubmit").click();
    } else{
        showModal("Please choose R before doing anything lewd.");
    }
}

function showModal(text){
    PF("growl").renderMessage({
        'summary': "ERROR",
        'detail': text,
        'severity': "error"
    });
}
function getRValue(){
    let rVal = document.getElementById("content:rVal_input").value;
    document.getElementById("hidden:hiddenR").value = rVal;
    return rVal;
}

function setXValue(value){
    let xVal = document.getElementById("hidden:hiddenX");
    xVal.value = value;
    // xVal.childNodes.forEach((node)=>{
    //     if(node.value === value)
    //         node.selected = true;
    //     else if(node.selected)
    //         node.selected = false;
    // });
}
function setYValue(value){
    let yVal = document.getElementById("hidden:hiddenY");
    yVal.value = value;
}
function update(){
    const rValueVal = document.getElementById("form:rVal_hidden");
    let newR = rValueVal.value;
    scaleCircles(newR);
    updateLabels(newR);
}
function scaleCircles(newR){
    for(let circle of circlePoints){
        let newX = circle.dataset.x/newR;
        let newY = circle.dataset.y/newR;
        circle.style = `transform: translate(${newX}px, ${-newY}px)`;
    }
}

function updateLabels(value){
    const newLabels = {
        'r-x': value,
        'r-x-half': value/2,
        'neg-r-x-half': -value/2,
        'neg-r-x': -value,
        'r-y': value,
        'r-y-half': value/2,
        'neg-r-y-half': -value/2,
        'neg-r-y': -value
    }
    for(let label of svgLabels){
        console.log(label);
        if(newLabels[label.id])
            label.innerHTML = newLabels[label.id];
    }
}

