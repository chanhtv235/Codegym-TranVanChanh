function Cat() {
    this.setNameCat=function (nameCat) {
        this.name=nameCat;
    };
    this.getNameCat =function () {
        return this.name;
    };
    this.setWeightCat= function (weightCat) {
        this.weightCat=weightCat;
    };
    this.getWeightCat=function () {
        return this.weightCat;
    };
    this.setSpeedCat=function (speedCat) {
        this.speedCat=speedCat;
    };
    this.getSpeedCat=function () {
        return this.speedCat;

    };
    this.sayCat= function () {
        return "meo meo";
    };
    this.catCatchMouse= function (Mouse) {
         if (this.getSpeedCat()>Mouse.speedMouse){
             this.sayCat();
             return true;
         }
    };
    this.catEatMouse=function (Mouse) {
        if (Mouse.statusMouse&&this.catCatchMouse(Mouse)) {
            this.weightCat += Mouse.weightMouse;
        }
        return true;
    };
}