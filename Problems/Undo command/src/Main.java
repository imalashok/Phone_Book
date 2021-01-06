interface Movable {
    int getX();
    int getY();
    void setX(int newX);
    void setY(int newY);
}

interface Storable {
    int getInventoryLength();
    String getInventoryItem(int index);
    void setInventoryItem(int index, String item);
}

interface Command {
    void execute();
    void undo();
}

class CommandMove implements Command {
    Movable entity;
    int xMovement;
    int yMovement;

    private int xMove = Integer.MIN_VALUE;
    private int yMove = Integer.MIN_VALUE;
    @Override
    public void execute() {
        xMove = xMovement;
        yMove = yMovement;

        entity.setX(entity.getX() + xMovement);
        entity.setY(entity.getY() + yMovement);
    }

    @Override
    public void undo() {
        if (xMove != Integer.MIN_VALUE && yMove != Integer.MIN_VALUE) {
            entity.setX(entity.getX() - xMove);
            entity.setY(entity.getY() - yMove);

            xMove = Integer.MIN_VALUE;
            yMove = Integer.MIN_VALUE;
        }
    }
}

class CommandPutItem implements Command {
    Storable entity;
    String item;

    private int index = -1;

    @Override
    public void execute() {
        for (int i = 0; i < entity.getInventoryLength(); i++) {
            if (entity.getInventoryItem(i) == null) {
                entity.setInventoryItem(i, item);
                index = i;
                break;
            }
        }
    }

    @Override
    public void undo() {
        if (index != -1) {
            entity.setInventoryItem(index, null);
            index = -1;
        }

    }
}