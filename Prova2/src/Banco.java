import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Banco { ;
        private JPanel BancoTela;
        private JButton ButSaque;
        private JButton ButDeposito;
        private JTextField Deposito;
        private JTextField Saque;
        private JButton Butlimpar;
        private JLabel txtSaldo;;

        private JLabel Mensagens;

       double saldo = 500.0;



    public static void main(String[] args) {

            JFrame tela = new JFrame("SISTEMA BANCARIO");
            tela.setContentPane(new Banco().BancoTela);
            tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            tela.setSize(600, 400);
            tela.setVisible(true);

        }





        public void saque() {

            try {
                double valorDigitado = Double.parseDouble(Saque.getText());

                if (valorDigitado > saldo) {
                    Mensagens.setText("erro o valor digitado é maior que o Saldo disponivel");
                } else {
                    saldo -= valorDigitado;
                    atualizaSaldo();
                    Mensagens.setText("Saque Realizado com sucesso.");
                }

            } catch (Exception e) {
                System.out.println("ERRO");
            }

        }






        public void depositar() {

            try {

                double valorDigitado = Double.parseDouble(Deposito.getText());

                if (valorDigitado <= 1000) {
                    saldo += valorDigitado;
                    atualizaSaldo();
                } else {
                    Mensagens.setText("erro os depósitos são permitidos no valor de até 1000");
                }
            } catch (Exception e) {
                System.out.println("ERRO");
            }
        }




    public void atualizaSaldo() {

        txtSaldo.setText(String.valueOf(saldo));
    }





    public Banco() {

        atualizaSaldo();

            ButSaque.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saque();
                }
            });

           ButDeposito.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    depositar();
                }
            });

           Butlimpar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {

               }
           });


    }
    }
