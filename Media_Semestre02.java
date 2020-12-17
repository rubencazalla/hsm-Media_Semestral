import java.util.Scanner;

public class Media_Semestre02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String nome;
			int prova 		= 5; 
			int projeto		= 3;  
			int exercicio 	= 2;
			int qtdAlunos   = 0;
			int nAprovados 	= 0;
			int nRprovados 	= 0;
			int nAf 		= 0;
			double nota1,nota2,nota3,notaAf,sem1,sem2;
			double mediaGeral = 0;
			double menor = 0;
			double maior=0;
			double bim1=0;
			double bim2=0;

			
			
			Scanner Al =  new Scanner(System.in);
			System.out.print("Informe o numero de alunos.");
			qtdAlunos = Al.nextInt();
			String [][]alunos = new String[qtdAlunos][3];
		
			
			Scanner Nota =  new Scanner(System.in);
			sem1=0;
			sem2=0;
			Scanner Al2 =  new Scanner(System.in);
			System.out.println("Informe a Disciplina para lançamento das notas:	  ");
			
			String disciplina = Al2.nextLine();

				for(int x=0;x < qtdAlunos;x++){
					nota1=0;
					nota2=0;
					nota3=0;
				
					System.out.println("Informe o Nome do Aluno	  ");
					nome = Al2.nextLine();
					
					for(int y=1;y<=4;y++) {
						System.out.println("*************************************************************");
						System.out.println("*                     "+y+"° Bimestre                       *");
						System.out.println("*************************************************************");
						
						System.out.print("Informe a Nota da Prova	  ");
						nota1 = Nota.nextDouble();
					
						System.out.print("Informe a Nota do Projeto	  ");
						nota2 = Nota.nextDouble();

						System.out.print("Informe a Nota do Exercício ");
						nota3= Nota.nextDouble();
						
						if(y==1) {
							bim1=((nota1*prova)+(nota2*projeto)+(nota3*exercicio))/(prova+projeto+exercicio);
						}else {
							bim2=((nota1*prova)+(nota2*projeto)+(nota3*exercicio))/(prova+projeto+exercicio);
						}
						
						if(y==2) {
							sem1=(bim1+bim2)/2;
						}
						if(y==4) {
							sem2=(bim1+bim2)/2;
							
							if((sem1+sem2)/2 < 5 ) {
								System.out.println("Aluno reprovado ");
								//reprovado
								alunos[x][0]= nome;
								alunos[x][1]= Double.toString((sem1+sem2)/2);
								alunos[x][2]= "Reprovado";		
								nRprovados=nRprovados+1;
							}else if((sem1+sem2)/2 > 5 && (sem1+sem2)/2<=7.9 ){
								System.out.println("Aluno Necessita realiar a AF ");
								System.out.println("Nota Necessaria para Aprovacao: "+ Math.round((10+(-(sem1+sem2)/2))* 100.0)/100.0);
								System.out.println("Informe a Nota da AF ");
								notaAf = Nota.nextDouble();
								nAf=nAf+1;
								if(notaAf<(10+(-(sem1+sem2)/2))) {
							
									alunos[x][0]= nome;
									alunos[x][1]= Double.toString(notaAf);
									alunos[x][2]= "Reprovado - AF";	
									nRprovados=nRprovados+1;
								}else {
								
									alunos[x][0]= nome;
									alunos[x][1]= Double.toString(notaAf);
									alunos[x][2]= "Aprovado -AF";		
									nAprovados=nAprovados+1;
								}
								
							}else {
								
								alunos[x][0]= nome;
								alunos[x][1]= Double.toString(Math.round(((sem1+sem2)/2)* 100.0)/100.0);
								alunos[x][2]= "Aprovado";	
								nAprovados=nAprovados+1;
							
							}					
							if(menor==0 || Double.parseDouble(alunos[x][1])< menor) {
								menor=Double.parseDouble(alunos[x][1]);
							}
							if(maior==0 || Double.parseDouble(alunos[x][1])> maior){
								maior=Double.parseDouble(alunos[x][1]);
							}
							mediaGeral+=Double.parseDouble(alunos[x][1]);
						}
						
						
					}	
				}
				System.out.println("															 ");
				System.out.println("															 ");
				System.out.println("#############################################################");
				System.out.println("# Disciplina : "+disciplina+"                                ");
				System.out.println("#============================================================");
				System.out.println("# Entrada de Dados dos alunos                                ");
				System.out.println("#============================================================");
				System.out.println("# Quantidade de Alunos :"+qtdAlunos+"                        ");
				System.out.println("#============================================================");
				System.out.println("#															 ");
				System.out.println("# Menor Nota :"+menor+"                                      ");
				System.out.println("# Maior Nota :"+maior+"                                      ");
				System.out.println("#															 ");
				System.out.println("#Numero de Aprovados :"+nAprovados+"						 ");
				System.out.println("#Numero de Reprovados:"+nRprovados+"						 ");
				System.out.println("#Numero de AF        :"+nAf+"								 ");
				System.out.println("#===========================================================#");
				System.out.println("# Média Turma :"+Math.round(((mediaGeral/qtdAlunos)* 100.0)/100.0));
				System.out.println("#===========================================================#");			
				System.out.println("#===========================================================#");
				System.out.println("#...................Lista dos Alunos........................#");
				System.out.println("#===========================================================#");
				System.out.println("#############################################################");
				System.out.println("Nome:                        |Nota          |Status          ");
				System.out.println("-------------------------------------------------------------");
				
				for(int i=0;i<alunos.length;i++){
					System.out.println(alunos[i][0].length()<= 29 ? String.format ("%-29.29s",alunos[i][0]) +"|"+ String.format ("%-14.14s",alunos[i][1])+"|"+ alunos[i][2] : alunos[i][0].substring(0, 29) +"|"+ alunos[i][1]+"|"+ alunos[i][2] );	

				}
				Al.close();
				Al2.close();
				Nota.close();
		
	}

}
