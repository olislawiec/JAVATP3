package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;
 
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;
 
public class ThirdPartyDoorAdapter extends ThirdPartyDoor implements Door{
       
       
                private String adapter_code = new String(DEFAULT_CODE);
        public boolean testCode(String code)
        {
                return code.equals(adapter_code);
        }
        public void open(String code) throws IncorrectDoorCodeException
        {
                if (adapter_code.equals(code) == false) throw new IncorrectDoorCodeException();
                try
                {
                        unlock(adapter_code);
                        setState(DoorState.OPEN);
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
             
                if (getState() == DoorState.OPEN) return true; else return false;
        }
        public void changeCode(String oldCode, String newCode, String newCodeConfirmation)
                        throws IncorrectDoorCodeException, CodeMismatchException {
               
                if (newCode.equals(newCodeConfirmation)) {
                        try {
                                unlock(oldCode);
                                setNewLockCode(newCode);
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
                        setState(DoorState.CLOSED);
                }
                catch(CannotChangeStateOfLockedDoor ex)
                {
                        System.out.println(ex);
                }
        }
 
}