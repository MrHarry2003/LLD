public class DedicationManagement {

    public void dedicateBrick(Owner ownerOfBrick,String toOwnerId, String brickId) {
        Owner toOwner=UserManagement.ownerMap.get(toOwnerId);
        Brick brick=City.ownedBrick.get(brickId);
        //brick should have animation true as after 10 animations it won't have it visible on wall
        //so at that time it should be false
        if (brick.isVisibleAnimation) {
            String ownerId = toOwner.id;
            //updating the object
            Owner.allOwner.get(ownerId).noOfDedications++;
        }
    }

    public String getHottestGuy() {
        String hottestGuy = "No Hottest Guy Here";
        int max = 0;
        for (Owner maleOwner : Owner.allOwner.values()) {
            if (maleOwner.gender.trim().equalsIgnoreCase("male")) {
                if (maleOwner.noOfDedications > max) {
                    max = maleOwner.noOfDedications;
                    hottestGuy = maleOwner.name;
                }
            }
        }
        if(hottestGuy.trim().equalsIgnoreCase("No Hottest Guy Here")){
            return hottestGuy;
        }
        return hottestGuy + " With "+max+" dedications";
    }

    public String getHottestGirl() {
        String hottestGirl = "No Hottest Girl Here";
        int max = 0;
        for (Owner femaleOwner : Owner.allOwner.values()) {
            if (femaleOwner.gender.trim().equalsIgnoreCase("female")) {
                if (femaleOwner.noOfDedications > max) {
                    max = femaleOwner.noOfDedications;
                    hottestGirl = femaleOwner.name;
                }
            }
        }
        if(hottestGirl.trim().equalsIgnoreCase("No Hottest Girl Here")){
            return hottestGirl;
        }
        return hottestGirl + " With "+max+" dedications";
    }

    public void getNoDedicationPerson() {
        for (Owner owner : Owner.allOwner.values()) {
            if (owner.noOfDedications == 0) {
                System.out.println(owner.name + " has 0 dedications by other.");
            }
        }
    }
}