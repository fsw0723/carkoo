<%@ attribute name="car"  type="com.carkoo.model.Car"%>
<div class="product">
    <div class="title">
        ${car.name}
    </div>
    <div class="photo">
        <img src=${car.photoUrl} height="100%" width="100%"/>
    </div>
    <div class="info">
        ${car.information}
    </div>
</div>