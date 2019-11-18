function Mouse() {

    this.setNameMouse=function (nameMouse) {
        this.nameMouse=nameMouse;
    };
    this.getNameMouse =function () {
        return this.nameMouse
    };
    this.setWeightMouse= function (weightMouse) {
        this.weightMouse=weightMouse;
    };
    this.getWeightMouse=function () {
        return this.weightMouse;
    };
    this.setSpeedMouse=function (speedMouse) {
        this.speedMouse=speedMouse;
        console.log(this.speedMouse)
    };
    this.getSpeedMouse=function () {
        return this.speedMouse;
    };
    this.sayMouse= function () {
        return "chit chit";
    };
    this.setSatusMouse =function (statusMouse) {
        this.statusMouse=statusMouse;
    };
    this.getStatusMouse= function () {
        return this.status;
    }
        
}
function Run() {
    alert("2");
}

Run();