// Component Interface
interface Character {
    void performAction();
}

// Concrete Component
class BasicCharacter implements Character {
    @Override
    public void performAction() {
        System.out.println("Character performs basic action: Walking...");
    }
}

// Abstract Decorator Class
abstract class CharacterDecorator implements Character {
    protected Character decoratedCharacter;

    public CharacterDecorator(Character decoratedCharacter) {
        this.decoratedCharacter = decoratedCharacter;
    }

    public void performAction() {
        decoratedCharacter.performAction();
    }
}

// Concrete Decorator #1: Magic Skill
class MagicSkillDecorator extends CharacterDecorator {
    public MagicSkillDecorator(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    @Override
    public void performAction() {
        decoratedCharacter.performAction();
        castMagic();
    }

    private void castMagic() {
        System.out.println("Character casts a powerful magic spell!");
    }
}

// Concrete Decorator #2: Sword Skill
class SwordSkillDecorator extends CharacterDecorator {
    public SwordSkillDecorator(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    @Override
    public void performAction() {
        decoratedCharacter.performAction();
        useSword();
    }

    private void useSword() {
        System.out.println("Character skillfully wields a sword!");
    }
}

// Demo class
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        // Basic character without any skills
        Character basicCharacter = new BasicCharacter();
        
        System.out.println("## Basic Character Actions ##");
        basicCharacter.performAction();

        // Character with Magic skill decorator
        Character magicCharacter = new MagicSkillDecorator(basicCharacter);
        
        System.out.println("\n** Character with Magic Skill **");
        magicCharacter.performAction();

        // Character with Magic and Sword skill decorators combined
        Character fullySkilledCharacter = new SwordSkillDecorator(magicCharacter);
        
        System.out.println("\n** Character with Magic and Sword Skills **");
        fullySkilledCharacter.performAction();
    }
}
