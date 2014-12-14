package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;
 
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.ThirdPartyDoor.DoorState;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;
 
public class ThirdPartyDoorObjectAdapter implements Door{
        ThirdPartyDoor door=new ThirdPartyDoor();
        private String adapter_code = new String(door.DEFAULT_CODE);
    public boolean testCode(String code)
    {
            return code.equals(adapter_code);
    }
    public void open(String code) throws IncorrectDoorCodeException
    {
            if (adapter_code.equals(code) == false) throw new IncorrectDoorCodeException();
            try
            {
                door.unlock(adapter_code);
                door.setState(DoorState.OPEN);
            }
            catch(CannotUnlockDoorException ex)
            {
                    throw new IncorrectDoorCodeException();
            }
            catch(CannotChangeStateOfLockedDoor ex)
            {
                    System.out.println(ex);
            }
    }
    public boolean isOpen()
    {
         
            if (door.getState() == DoorState.OPEN) return true; else return false;
    }
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation)
                    throws IncorrectDoorCodeException, CodeMismatchException {
           
            if (newCode.equals(newCodeConfirmation)) {
                    try {
                        door.unlock(oldCode);
                        door.setNewLockCode(newCode);
                            adapter_code = new String(newCode);
                    }
                    catch (CannotUnlockDoorException ex)
                    {
                            throw new IncorrectDoorCodeException();
                    }
                    catch (CannotChangeCodeForUnlockedDoor ex)
                    {
                            System.out.println(ex);
                    }
                   
                   
            }
            else
            {
                    throw new CodeMismatchException();
            }
    }
    public void close()
    {
            try
            {
                door.setState(DoorState.CLOSED);
            }
            catch(CannotChangeStateOfLockedDoor ex)
            {
                    System.out.println(ex);
            }
    }
 
}