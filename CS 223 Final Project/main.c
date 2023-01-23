#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>
void asteroid();
int lineCheck(char filename[])
{
    FILE *fp;
    int count = 0;
    char c;
    fp = fopen(filename, "r");
    // Extract characters from file and store in character c
    for (c = getc(fp); c != EOF; c = getc(fp))
        if (c == '\n') // Increment count if this character is newline
            count++;
    // Close the file
    fclose(fp);
    return count;
}
struct asteroidStruct{
    char ID[1];
    int posX;
    int posY;
    int posZ;
    float Mag;
}ast[1000];
int usertries = 0;
struct ident{
    char user[5];
    int password;
}ident[1000];
int passwordCheck(struct ident x);
void asteroid();
int login(){
    FILE * fp;
    fp = fopen("ident.txt", "r");
    int identLines = lineCheck("ident.txt");
    
    char user[5];
    while(usertries <3){
        printf("input username\n");
        scanf("%s", user);
        int resultuser[1000];
        for(int i=0; i<=identLines; i++){
            fscanf(fp, "%s", ident[i].user);
            fscanf(fp, "%i", &ident[i].password);
            resultuser[i] = strcmp(user,ident[i].user);
        }
        for(int i=0; i<=identLines; i++){
            if(resultuser[i]==0){
                passwordCheck(ident[i]);
            } else if(i>=identLines){
                usertries++;
                if(usertries<3){
                printf("Bad Username, please try again (Tries %d/3)\n", usertries);
                }
                if(usertries == 3){
                    printf("\nToo many tries. Goodbye.");
                    return 1;
                }
            }
        }
    }
    fclose(fp);
    return 0;
}
int main(){
    login();
    return 0;
}
int passwordCheck(struct ident x){
    int pass;
    int passtries = 0;
    while(passtries<3){
        printf("input pass\n");
        scanf("%d", &pass);
        
        if(pass == x.password){
            system("clear");
            printf("Welcome, %s.\n\n",x.user);
            passtries=4;
            usertries=4;
            asteroid();
        }else{
            passtries++;
            if(passtries<3){
                printf("Bad password, please try again (Tries %d/3)\n", passtries);
            }
            if(passtries == 3){
                printf("\nToo many tries. Goodbye.");
                usertries=4;
                return 1;
            }
        }
    }
}
void asteroid(){
    FILE * fp;
    int tempCh;
    int astArr[100][5];
    float num[100];
    int j=0,i=0;
    float a;
    int n;
    // Array Style:
    // AstName X Y Z Distance
    fp = fopen("asteroid.txt", "r");
    int asteroidLines = lineCheck("asteroid.txt");
    n = asteroidLines;
    for(i; i<=asteroidLines; i++){
        fscanf(fp, "%s", ast[i].ID);
        fscanf(fp, "%i", &ast[i].posX);
        fscanf(fp, "%i", &ast[i].posY);
        fscanf(fp, "%i", &ast[i].posZ);
        ast[i].Mag = sqrt((ast[i].posX*ast[i].posX)+(ast[i].posY*ast[i].posY)+(ast[i].posZ*ast[i].posZ));
        num[i]=ast[i].Mag;
    }
    fclose(fp);
    for (i = 0; i < n-1; ++i){
        for (j = 0; j < n-i; ++j){
            if (num[j] > num[j+1]){
                a =  num[j];
                num[j] = num[j+1];
                num[j+1] = a;
            }
        }
    }
    FILE* fpn;
    fpn = fopen("distance.txt", "w+");
    printf("WARNING - WARNING - WARNING\n\n");
    for(i=0; i<=asteroidLines; i++){
        for(j=0;num[i]!=ast[j].Mag;j++){
        }
        fprintf(fpn,"%s %i %i %i %f \n", ast[j].ID,ast[j].posX,ast[j].posY,ast[j].posZ,ast[j].Mag);
        if(ast[j].Mag<750 && i==0){
            printf("Nearest asteroid %s at %i, %i, %i: %.2fkm away",ast[j].ID,ast[j].posX,ast[j].posY,ast[j].posZ,ast[j].Mag);
            float timetoimpact=ast[j].Mag/25;
            printf("\nTime to impact: %.0f seconds\n\n", timetoimpact);
        }else if(ast[j].Mag<750){
            printf("Asteroid %s at %i, %i, %i: %.2fkm away\n\n",ast[j].ID,ast[j].posX,ast[j].posY,ast[j].posZ,ast[j].Mag);
        }
    }
    fclose(fpn);
}