In order to be able to run the command you need to run it from the directory: src/main/java/utils/deletePhoneNumbers/utils/
1. use the below command in the terminal.
2. USER_RANGE_MIN= is the first 4 digits phone number
3. USER_RANGE_MAX= is the last 4 digits phone number
4. change in the URL's the environment to integration or staging


USER_RANGE_MIN=0001 USER_RANGE_MAX=0007 K_IDENTITY_API_URL=https://identity.staging.khealth.xyz K_API_URL=https://api.staging.khealth.xyz npx ts-node delete-user-range.ts