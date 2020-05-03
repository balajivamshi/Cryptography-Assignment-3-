String s = txtAES.getText();
if (s.equals(null) || s.equals("") || s.length() < 16 || s.length() > 16) {
 OptionPane.showMessageDialog(null, "Please insert the right 16 digit secret key");
} else {
//k is the user INPUT,received in text form and convert into bytes,AES only reads bytes
 k = txtAES.getText().getBytes();
aeskeySpec = new SecretKeySpec(k, "AES");
File fileToEncrypt = new File(txtPath.getText());
JFileChooser chooser=new JFileChooser();
if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
encryptedKeyFile = chooser.getSelectedFile();
String filename=encryptedKeyFile.getName();
if (filename.equalsIgnoreCase("aes.key")){
saveKey(encryptedKeyFile, publicKeyFile);
encrypt(fileToEncrypt, encryptedFileLoc);
txtPath.setText("");
txtFileName.setText("");
txtAES.setText("");}
else{
JOptionPane.showMessageDialog(null,"Please choose the right key file",
"Key Error", JOptionPane.ERROR_MESSAGE);} 
}