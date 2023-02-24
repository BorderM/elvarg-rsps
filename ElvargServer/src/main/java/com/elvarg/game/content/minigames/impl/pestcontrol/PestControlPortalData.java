package com.elvarg.game.content.minigames.impl.pestcontrol;

import com.elvarg.game.model.Direction;
import com.elvarg.game.model.equipment.BonusManager;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ynneh | 24/02/2023 - 02:40
 * <https://github.com/drhenny>
 */
public enum PestControlPortalData {

    PURPLE("western", Direction.WEST, "a533ff", 1751, 1747, Arrays.asList(BonusManager.ATTACK_RANGE), 2628, 2591),
    BLUE("eastern", Direction.EAST, "33d7ff", 1752, 1748, Arrays.asList(BonusManager.ATTACK_MAGIC), 2680, 2588),
    YELLOW("south-eastern", Direction.SOUTH_EAST, "fff333", 1753, 1749, Arrays.asList(BonusManager.ATTACK_STAB, BonusManager.ATTACK_SLASH),
            2669, 2570),
    RED("south-western", Direction.SOUTH_WEST, "e32a2a", 1754, 1750, Arrays.asList(BonusManager.ATTACK_CRUSH),2645, 2569)
    ;

    public Direction direction;

    public String name, colourCode;

    public List<Integer> weaknesses;
    public int shieldId, unshieldId;

    public int xPosition, yPosition;
    PestControlPortalData(String name, Direction direction, String colourCode, int shieldId, int unshieldId, List<Integer> weaknesses, int xPosition, int yPosition) {
        this.name = name;
        this.direction = direction;
        this.colourCode = colourCode;
        this.weaknesses = weaknesses;
        this.shieldId = shieldId;
        this.unshieldId = unshieldId;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
}
