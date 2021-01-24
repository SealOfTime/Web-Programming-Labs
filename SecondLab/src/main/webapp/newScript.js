const pointForm = document.getElementById("form-point");
const xValues = document.getElementsByName("x");
const yValue = document.getElementById("y-value");
const rValues = document.getElementsByName("r");

const plotCanvas = document.getElementById("plot-canvas");
const circles = document.getElementsByTagName("circle");
const svgLabels = document.getElementsByTagName("text");

//const pointEntries = document.getElementsByClassName("point-entry");

const modal = document.getElementById("modal");
const modalContent = document.querySelector("#modal #content");
window.addEventListener("load", ()=>scaleCircles(body.dataset.newR));
// pointEntries.forEach(pointEntry => pointEntry.addEventListener("hover", e=>{
//     console.log(hover);
// }));
rValues.forEach( rVal => rVal.addEventListener("change", (e)=>{
    console.log(e);
    scaleCircles(rVal.value);
    updateLabels(rVal.value);
}));

plotCanvas.addEventListener("click", (e)=>{
    const rect = plotCanvas.getBoundingClientRect();
    const r = getRValue();
    if(r) {
        const x = (e.clientX - rect.left - 200) * r / 160;
        if(x > 2 || x < -2){
            showModal("X should be between -2 and 2");
            return false;
        }
        const y = -(e.clientY - rect.top - 200) * r / 160;
        if(y < -3 || y > 3){
            showModal("Y should be between -3 and 3");
            return false;
        }
        console.log("x: " + x + " y: " + y);
        setXValue(x);
        setYValue(y)
        pointForm.submit();
    } else{
        showModal("Please choose R before doing anything lewd.");
    }
})

function showModal(message){
    modalContent.innerHTML = message;
    modal.style = "display: block";
    modal.classList.add("active");
}

function closeModal(){
    modal.classList.remove("active");
    modal.addEventListener("transitionend", ()=>modal.style="display: none");
}
function scaleCircles(newR){
    for(let circle of circles){
        let newX = circle.dataset.x/newR;
        let newY = circle.dataset.y/newR;
        circle.style = `transform: translate(${newX}px, ${-newY}px)`;
    }
}

function getRValue(){
    for(let rVal of rValues)
        if(rVal.checked)
            return rVal.value;
}

function getXValues(){
    let result = [];
    for(let xVal of xValues)
        if(xVal.checked)
            result.push(xVal)
    return result;
}

function setXValue(value){
    for(let xVal of xValues)
        if(xVal.checked)
            xVal.checked = false;
    let elem = document.createElement("input");
    elem.type = 'hidden';
    elem.name = "x";
    elem.value = value;
    pointForm.appendChild(elem);
}

function setYValue(value){
    yValue.value = value;
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